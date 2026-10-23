# Практическая работа №5

REST API пользователей на Spring Boot.

ФИО: Илья Фидоренко Николаевич  
Группа: ИС-11-24-2

## Методы

- `GET /users`
- `GET /users/{id}`
- `POST /users`
- `PUT /users/{id}`
- `DELETE /users/{id}`

## Запуск

```bash
mvn spring-boot:run
```

Пример тела запроса:

```json
{"name":"Иван Иванов","email":"ivan@example.com"}
```
