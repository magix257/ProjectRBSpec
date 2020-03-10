  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset=UTF-8>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
<img src="logoetiko.svg" width="447.029" height="95.04" />
</div>
 <div class="container-fluid">
 <div class="container">
<div class="table-responsive">
  <table class="table">
    <thead>
      <tr>
        <th>Specyfikacja</th>
        <th>Nazwa</th>
        <th>Wykrojnik</th>
        <th>Materiał</th>
        <th>Szerokość Materiału</th>
        <th>Wymiar Etykiety</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><b>${specyfikacja}</b></td>
        <td>${nazwa}</td>
        <td><b>${wykrojnik}</b></td>
        <td>${material}</td>
        <td>${szerokoscMaterialu}</td>
        <td>${wymiarEtykiety}</td>
      </tr>
    </tbody>
  </table>
  </div>
 </div>

</div>
</body>
</html>