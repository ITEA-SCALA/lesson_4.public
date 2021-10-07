### Mutable linked list with methods add, remote and print.

```scala
package com.itea.task3
```


Declare item list
```scala
val items: Item = Item()
```

Add new item to list
```scala
items add Some(1, "one")
items add Some(2, "two")
items add Some(3, "three")
items add Some(4, "four")
```

Remove item from list
```scala
items.remove
items.remove
```

Print all list of item(s)
```scala
items.print
// NIL  { id:1, title:one }  { id:2, title:two }  { id:33, title:thirty three }  { id:444, title:four hundred forty four }  { id:555, title:five hundred fifty five }  { id:666, title:six hundred sixty six }
```

Use Iterator to iterate the list
```scala
var iterator: Iterator = Iterator()
while ( iterator.hasNext ) {
  val next: Item = iterator.next
  println( "value = " + next.value )
}
```

![Screenshot-1](screenshot-1.png)


---

### Simple project with desired structure for small web service, including one congig, one repository, one controller and service.

```scala
package com.itea.task2
```


---

[Zoom * Ссылка на запись 4 занятия](https://us02web.zoom.us/rec/play/ef9bblHtV4JpV2QdEyAdsUrFk91oEIAtt9_iqT8gdD2eFAq0su7jZxuyo3RRnQlDPmz0ClsxU4w4ijDY.m3kqOZ1oEHar6yJ7?continueMode=true&_x_zm_rtaid=fU30Sl53Q7aSgbFjdd5gZQ.1633530332861.7d6e92a77de49932e53a113ad642839d&_x_zm_rhtaid=829)