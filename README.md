## How to run the demo
```bash
git clone https://github.com/HungYipNTT/gaia-backend-spring-jpa-rest-demo.git

cd gaia-backend-spring-jpa-rest-demo

# for window user installed with Docker Desktop
docker compose -f demo-docker-compose.yaml up -d

# for window user installed with podman Desktop
podman compose -f demo-docker-compose.yaml up -d

curl localhost:8080/customers
```