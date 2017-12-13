# Paperplane

## Postgresql (Docker)

- cd src/main/docker
- docker build -t paperplane .
- docker run  —name paperplane_db -p 5432:5432 —rm paperplane

## Frontend

### Build

- cd src/main/frontend
- npm install
- npm run build

### Dev
- npm install
- npm run start -s

Execute the app and go to localhost:8080