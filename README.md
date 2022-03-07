## JSON path for Gson
#### Tool to search, update or set a value in a JSON using JSON path

Json path examples to get the value '1':
```
PATH: [0] -> JSON: [1,2]
PATH: id -> JSON: {"id":1}
PATH: id[0] -> JSON: {"id":[1,2]}
PATH: id.sub_id -> JSON: {"id":{"sub_id":1}}
PATH: id.sub_id[0] -> JSON: {"id":{"sub_id":[1,2]}}
PATH: id[0].sub_id -> JSON: {"id":[{"sub_id":1},{"sub_id":2}]}
PATH: [0].id -> JSON: [{"id":1},{"id":2}]
```