<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modal Example</title>
    <style>
        /* Style for the modal background */
        .modal {
            display: block; /* Show the modal */
            position: fixed;
            z-index: 1;
            padding-top: 100px;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,1); /* Black background with opacity */
        }

        /* Style for the modal content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            position: relative;
        }

        /* The close button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

<!-- Modal structure -->
<div id="myModal" class="modal">
  <div class="modal-content">
    <span class="close">&times;</span>
    <p>Added succesfully</p>
  </div>
</div>

<script type="text/javascript">
    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the close button
    var closeBtn = document.getElementsByClassName("close")[0];

    // Close the modal when the close button is clicked
    closeBtn.onclick = function() {
        modal.style.display = "none";
    }

    // Close the modal when clicking anywhere outside the modal content
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

</body>
</html>
