rem curl -v -XPOST "localhost:8880/PostEvent" -H "Content-Type: application/json" -d '{"id":"id01","number":1,"type":"button"}'
curl -v -H "Content-Type: application/json" -d "{\"id\":\"id01\", \"number\":1, \"type\":\"button\"}" localhost:8880/PostEvent
pause
