MUTATION: 

```graphql
mutation($prog: ProgInput!) {
    addProg(prog:$prog) {
        name
        type
            statements {
                name
                type
                args {
                    name
                    type
                }
            }
    }
}
```
MUTATION VARIABLE:

```graphql
{
    "prog":{
        "name": "sdasdfsdfsdfsdfsa",
        "type": "sdasda",
        "statements": [
        {
            "name": "stat1",
            "type": "statt1",
            "args":[{
                "name": "Arg03",
                "type": "003"
            },
            {
                "name": "Arg03",
                "type": "003"
            }
            ]
        }
    ]
    }
}
```

<img src="C:\Users\Barna_Sipiczki\projects\examples\graphqldsl\graphqlkotlindsl\Screenshot 2023-07-07 at 12-31-59 Playground - http __localhost 8080_graphql.png"/>

QUERY:

```graphql
query GetProg {
 getProg {
  name,
  type,
 	statements {
    name,
    type,
    args {
      name,
      type
    }
  }
}
}
```
<img src="C:\Users\Barna_Sipiczki\projects\examples\graphqldsl\graphqlkotlindsl\Screenshot 2023-07-07 at 12-31-42 Playground - http __localhost 8080_graphql.png"/>
