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
    <h3 class="display-4">Archive list</h3>
    <table class="table table-striped table-sm">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Guest Name</th>
            <th>Room Number</th>
            <th>Check in</th>
            <th>Check out</th>
        </tr>
        </thead>
        <tbody>
        <#list checkings as checking>
            <tr>
                <td>${checking.id}</td>
                <td>${checking.guest.name}</td>
                <td>${checking.room.number}</td>
                <td>${checking.checkIn}</td>
                <td>${checking.checkOut}</td>

            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/" type="button" class="btn btn-success">Got to main</a>
</div>



</body>
</html>>