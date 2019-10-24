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
    <h3 class="display-4">Guest list</h3>
    <table class="table table-striped table-sm">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Forname</th>
            <th>Pass Data</th>
            <th>Comment</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <#list guests as guest>
            <tr>
                <td>${guest.id}</td>
                <td>${guest.name}</td>
                <td>${guest.forname}</td>
                <td>${guest.passData}</td>
                <td>${guest.comment}</td>
                <td>  <a href="/guest/delete/${guest.id}" type="button" class="btn btn-danger">Delete</a></td>
                <td>  <a href="/guest/update/${guest.id}" type="button" class="btn btn-primary">Update</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/guest/create" type="button" class="btn btn-success">Add new guest</a>
    <a href="/" type="button" class="btn btn-success">Got to main</a>
</div>



</body>
</html>