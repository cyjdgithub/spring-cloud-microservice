# Spring Cloud Microservices System 🚀

This is a production-ready microservices project built with **Spring Boot 3 / Spring Cloud 2023.x / JDK 17**, featuring service registration/discovery, fault tolerance, distributed tracing, monitoring, containerization, and Kubernetes deployment.

---

## 🧱 Project Structure

```
spring-cloud-micro/
├── api-gateway/            # Spring Cloud Gateway
├── order-service/          # Microservice: Order Service
├── product-service/        # Microservice: Product Service
├── user-service/           # Microservice: User Service
├── docker-compose.yml      # Local Docker environment
├── prometheus.yml          # Prometheus scrape config
├── k8s/                    # Kubernetes deployment YAMLs
│   ├── api-gateway.yaml
│   ├── order-service.yaml
│   ├── product-service.yaml
│   ├── user-service.yaml
│   └── consul.yaml
```

---

## 📊 Tech Stack

| Layer                | Tech                              |
| -------------------- | --------------------------------- |
| Microservice Runtime | Spring Boot 3 + Spring Cloud 2023 |
| Service Registry     | Consul                            |
| API Gateway          | Spring Cloud Gateway              |
| Communication        | OpenFeign                         |
| Fault Tolerance      | Resilience4J                      |
| Tracing              | Zipkin                            |
| Metrics Collection   | Prometheus                        |
| Visualization        | Grafana                           |
| Containerization     | Docker, Docker Compose            |
| Orchestration        | Kubernetes                        |

---

## 🛠️ How to Run Locally

### 1. Build All JARs

```bash
mvn clean package -DskipTests
```

### 2. Start with Docker Compose

```bash
docker-compose up --build
```

### Services & Ports

| Service     | URL                                            |
| ----------- | ---------------------------------------------- |
| API Gateway | [http://localhost:8080](http://localhost:8080) |
| Consul      | [http://localhost:8500](http://localhost:8500) |
| Zipkin      | [http://localhost:9411](http://localhost:9411) |
| Prometheus  | [http://localhost:9090](http://localhost:9090) |
| Grafana     | [http://localhost:3000](http://localhost:3000) |

> Grafana default credentials: `admin` / `admin`

---

## 🔢 Sample APIs

```
GET http://localhost:8080/users/1
GET http://localhost:8080/orders/1
GET http://localhost:8080/products/1
```

---

## ⚘️ Kubernetes Deployment

### 1. Build & Tag Docker Images

```bash
docker build -t api-gateway:latest ./api-gateway
docker build -t user-service:latest ./user-service
# ... repeat for other services
```

### 2. Apply K8s Manifests

```bash
kubectl apply -f k8s/
```

### 3. Port Forward (Optional)

```bash
kubectl port-forward service/api-gateway 8080:80
```
<img width="928" alt="image" src="https://github.com/user-attachments/assets/4523a494-dd52-44ed-b652-bbbe9d26b077" />

---

## 📊 Monitoring with Prometheus + Grafana

1. Access Grafana: [http://localhost:3000](http://localhost:3000)
2. Add Prometheus as a data source: `http://prometheus:9090`
3. Import dashboards or create your own.
4. All services expose metrics via `/actuator/prometheus`.

<img width="940" alt="image" src="https://github.com/user-attachments/assets/d273fcd1-f82e-42c2-a7eb-dbb242c0f539" />
<img width="1024" alt="image" src="https://github.com/user-attachments/assets/316e3200-9184-4b0a-834c-1243ab32b0fe" />



---

## 👨‍💼 Maintainer

Built and maintained by [cyjdgithub](https://github.com/cyjdgithub)

