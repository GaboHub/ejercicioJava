# Endpoints

## saveUser

- **Method**: `POST`
- **Path**: `/user`

#### Request body

```json
{
	"name": "name",
	"email": "email",
	"password": "password",
	"phones": [
			{
				"number":  "number",
				"citycode": "citycode",
				"countrycode": "countrycode"
			},
						{
				"number":  "number",
				"citycode": "citycode",
				"countrycode": "countrycode"
			}
		]
}
```

#### Valid response sample

- Status: `201`

```json
{
    "id": "id",
    "created": "2020-07-30T01:18:01.571",
    "modified": "2020-07-30T01:18:01.571",
    "token": "token",
    "name": "name",
    "email": "email",
    "password": "password",
    "phones": [
        {
            "id": "id",
            "number": "number",
            "citycode": "citycode",
            "countrycode": "countrycode"
        },
        {
            "id": "id",
            "number": "number",
            "citycode": "citycode",
            "countrycode": "countrycode"
        }
    ],
    "last_login": "2020-07-30T01:18:01.571",
    "isactive": true
}
```

## Get user

- **Method**: `GET`
- **Path**: `/user?username=value`
- **Headers**: Require authorization bearer with user token.

#### Valid response sample

- Status: `200`

```json
{
    "id": "id",
    "created": "2020-07-30T01:18:01.571",
    "modified": "2020-07-30T01:18:01.571",
    "token": "token",
    "name": "name",
    "email": "email",
    "password": "password",
    "phones": [
        {
            "id": "id",
            "number": "number",
            "citycode": "citycode",
            "countrycode": "countrycode"
        },
        {
            "id": "id",
            "number": "number",
            "citycode": "citycode",
            "countrycode": "countrycode"
        }
    ],`
    "last_login": "2020-07-30T01:18:01.571",
    "isactive": true
}
```

## Error Responses

- Status: `409` | `500

````json
{
    "message": "detailed error"
}
`````

Unsoported media type
- Status: `415`

