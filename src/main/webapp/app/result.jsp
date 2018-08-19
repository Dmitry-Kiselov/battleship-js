<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Result</title>
    <script src="https://www.w3schools.com/lib/w3.js"></script>
</head>

<h2>Game Over!</h2>

<body onload="displayWinner()">
<%--     onload="displayWinnerList()" >
--%>

<div id="winner" class="w3-hide">
    <h1>You win!</h1>
</div>
<div id="looser" class="w3-hide">
    <h1>You lose</h1>
</div>



<script>
    function displayWinner() {
        console.log("you win or lose");
        fetch("<c:url value='/api/game/status'/>", {
            "method": "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(function (response) {
            return response.json();
        }).then(function (game) {
            console.log(JSON.stringify(game));
            if (game.status === "FINISHED" && game.playerActive) {
                document.getElementById("winner").classList.remove("w3-hide");
            } else {
                document.getElementById("looser").classList.remove("w3-hide");
            }
        })
    }



</script>


</body>
</html>