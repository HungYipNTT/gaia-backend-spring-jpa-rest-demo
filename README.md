## How to run the demo
```bash
git clone https://github.com/HungYipNTT/gaia-backend-spring-jpa-rest-demo.git

cd gaia-backend-spring-jpa-rest-demo

# for window user installed with Docker Desktop
docker compose -f demo-docker-compose.yaml up -d

# for window user installed with podman Desktop
podman compose -f demo-docker-compose.yaml up -d

## URLs for demo

# check the available API after started the docker compose
curl localhost:8080/profile
curl localhost:8080/profile/customers
curl localhost:8080/profile/products
curl localhost:8080/customers/search
curl localhost:8080/products/search

# retrieve customer
curl localhost:8080/customers
curl localhost:8080/customers/1
curl localhost:8080/customers/search/findByEmail\?email=james.lewis@example.com

# retrieve product
curl localhost:8080/products
curl localhost:8000/products/1
curl localhost:8080/products/search/findByCategory\?category=hoodie

```