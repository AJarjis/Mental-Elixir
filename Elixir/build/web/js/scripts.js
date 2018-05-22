$(document).ready(function () {
    // Add smooth scrolling to all links
    $(".smoothScroll").on('click', function (event) {
        
        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {
            // Prevent default anchor click behavior
            event.preventDefault();

            // Store hash
            var hash = this.hash;

            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 800, function () {

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
        } // End if
    });

    // Search function for groups
    $("#groupSearch").on("keyup", function () {
        var value = $(this).val().toLowerCase();

        $("#listOfGroups .groupCard").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    // Hides nav bar upon scroll down and displays on scroll up
    var lastScrollTop = 0;
    var $navbar = $('.naiveBar');

    $(function () {
        $(window).scroll(function (event) {
            var st = $(this).scrollTop();

            if (st > lastScrollTop) { // scroll down
                $navbar.addClass("fade-out");
                $navbar.removeClass("fade-in");
            } else { // scroll up
                $navbar.addClass("fade-in");
                $navbar.removeClass("fade-out");
            }
            
            lastScrollTop = st;
        });
    });
    
    $(function(){
        $("#navBarPlaceholder").load("navBar.jsp");
      });
});


$('#carouselExampleSlidesOnly').carousel({
    pause: true,
    interval: false
});
       $(function(){
      $("#chartDiv").load("chart.jsp"); 
    });
