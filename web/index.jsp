<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JasperTest</title>
    </head>
    <body>
        <h1>Testing Jasper</h1>
        <input type="button" value="Test Jasper!" id="test" />
            
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script>
            
            $(document).ready(function() {
                
                $('#test').click(function() {
                    
                    $.ajax({
                        type: 'GET',
                        url: '/JasperTest/Jasper',
                        success: function(response) {
                            alert(response);
                        }, 
                        error: function(err) {
                            console.log(err);
                        }
                    });
                    
                });
                
            });
            
        </script>
    </body>
</html>
