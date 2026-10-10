# Starlink tracker

A Spring Boot service that pulls live orbital data for the whole Starlink constellation from [CelesTrak](https://celestrak.org), stores it in MySQL, and serves a 3D globe in the browser that propagates every satellite's position in real time.

## What it does

- **Syncs orbital elements** for all Starlink satellites (~10,000) from CelesTrak's GP data feed and stores them in MySQL.
- **Exposes a REST API** with pagination and sorting, documented with OpenAPI 3 / Swagger UI.
- **Renders the constellation on a 3D Earth** (three-globe + Three.js). Positions are propagated client-side from the orbital elements with SGP4 (satellite.js), at an adjustable simulation speed. Click a satellite to see its details.

## Stack

Java, Spring Boot 3.5 (Web, Data JPA), MySQL, Liquibase for schema migrations, springdoc-openapi, Docker Compose. The front end is a single page using three-globe, Three.js and satellite.js.

The back end follows a layered Controller → Service → Repository structure, with a separate REST client for CelesTrak.

## Running

```sh
docker compose up --build
```

Then:

1. Load data from CelesTrak once: `curl -X PUT http://localhost:6868/api/satellites`
2. Open the globe at http://localhost:6868
3. Browse the API at http://localhost:6868/swagger-ui.html

Ports and database settings are in `.env`.

## API

| Method | Path | Description |
|---|---|---|
| `GET` | `/api/satellites` | All satellites (used by the globe) |
| `GET` | `/api/satellites/all?page=0&size=20&sort=objectName,asc` | Paginated and sorted list |
| `GET` | `/api/satellites/{id}` | One satellite |
| `POST` | `/api/satellites` | Add a satellite |
| `PUT` | `/api/satellites/{id}` | Update a satellite |
| `PUT` | `/api/satellites` | Re-sync everything from CelesTrak |

## Notes

CelesTrak rate-limits repeated downloads of the same data set (roughly one fetch per update cycle, about every two hours), so avoid calling the sync endpoint in a loop.
