<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="container">
    <fieldset>
        <legend>Add checking</legend>
        <form name="checking" action="" method="POST">
            <br>Guest:<@spring.formSingleSelect "checkingForm.guest",listGuests,"class='form-control'"/>
            <br>Room:<@spring.formSingleSelect "checkingForm.room",listRoom,"class='form-control'"/>
            <br>Check in:<@spring.formInput "checkingForm.checkIn" "readonly" "text"/>
            <script>
                $('#checkIn').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>Check out:<@spring.formInput "checkingForm.checkOut" "readonly" "text"/>
            <script>
                $('#checkOut').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>Reserved:<@spring.formSingleSelect "checkingForm.reserved",reserved,"class='form-control'"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>