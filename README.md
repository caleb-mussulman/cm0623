### Dependencies


| Dependency | Version                    |
|------------|----------------------------|
| Java       | openjdk 17.0.7 2023-04-18  |
| Gradle     | 8.1.1                      |
| Docker     | 20.10.21                   |


### Running the Application
```
./gradlew clean build
docker-compose up --build
```

### Endpoint(s)
<table>
  <tr>
    <td> Method </td>
    <td> Endpoint </td>
    <td> Payload</td>
  </tr>

  <tr>
    <td> POST </td>
    <td> /depot/rental/checkout </td>
    <td>

```json
{
  "tool_code": "ABCD",
  "rental_day_count": 7,
  "discount_percent": 42,
  "checkout_date": "2023-06-13"
}
```

</td>
  </tr>
</table>
