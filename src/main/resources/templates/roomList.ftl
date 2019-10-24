<#import "/spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="display-4">Rooms list</h3>
    <table class="table table-striped table-sm">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Number</th>
            <th>Comfort</th>
            <th>Capacity</th>
            <th>Free Places</th>
            <th>Price</th>
            <th>Busy</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <#list rooms as room>
            <tr>
                <td>${room.id}</td>
                <td>${room.number}</td>
                <td>${room.comfort}</td>
                <td>${room.capacity}</td>
                <td>${room.freePlaces}</td>
                <td>${room.price}</td>
                <td>${room.busy?then("yes","no")}</td>
                <td>  <a href="/room/delete/${room.id}" type="button" class="btn btn-danger">Delete</a></td>
                <td>  <a href="/room/update/${room.id}" type="button" class="btn btn-primary">Update</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/room/create" type="button" class="btn btn-success">Add new room</a>
    <a href="/" type="button" class="btn btn-success">Got to main</a>
</div>



</body>
</html>>