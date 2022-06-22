<html>
<head>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        /* Style the submit button */
        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        /* Add a background color to the submit button on mouse-over */
        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
    <title>Title</title>
</head>
<body>
<form action="/save.do">
    <input type="text" id="cardPan" name="cardPan" placeholder="CARDPAN">
    <input type="text" id="personnelCode" name="personnelCode" placeholder="PERSONNEL CODE">
    <input type="text" id="branchCode" name="branchCode" placeholder="BRANCHCODE">
    <input type="text" id="ipAddress" name="ipAddress" placeholder="IPADDRESS">
    <input type="submit" value="register">
</form>
</body>
</html>