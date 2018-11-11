
<div class="footer" id="footer" style="background-color: #31b0d5">

    <center>
<!--          <c:out value="${nombre_autor}"/>-->
        Ali Smili

    </center>
    <script>
        $(document).ready(function () {

            var docHeight = $(window).height();
            var footerHeight = $('#footer').height();
            var footerTop = $('#footer').position().top + footerHeight;

            if (footerTop < docHeight)
                $('#footer').css('margin-top', 10 + (docHeight - footerTop) + 'px');
        });
    </script>
</div>



</body>
</html>
