<%@page import="Controller.UserController"%>
<nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
    <span id="title" class="navbar-text" style="font-size: 30px">elixir</span>
    <a class="navbar-brand" href="index.jsp">
        <img src="images/logo.svg" alt="logo" style="height: 40px">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="smoothScroll nav-link" href="index.jsp#moods">Moods</a>
            </li>
            <li class="nav-item">
                <a class="smoothScroll nav-link" href="index.jsp#adventures">Adventures</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Guilds</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="smoothScroll dropdown-item" href="createGroup.jsp">Create Guild</a>
                    <a class="smoothScroll dropdown-item" href="groups.jsp">Join Guild</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="faq.jsp">Help & Support</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">My Account</a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown01">
                    <% UserController user = (UserController) session.getAttribute("user"); %>
                    <p class="dropdown-header"><b>Username: </b><% out.print(user.getUserName()); %></p>
                    <p class="dropdown-header"><b>Name: </b><% out.print(user.getFullName()); %></p>
                    <p class="dropdown-header"><b>Email: </b><% out.print(user.getEmail());%></p>
                    <div class="dropdown-divider"></div>
                    <a class="smoothScroll dropdown-item bad-dropdown-item" href="" data-toggle="modal" data-target="#deleteAccountModal">
                        <i class="fas fa-minus-circle"></i> Delete Account</a>
                    <a class="smoothScroll dropdown-item warning-dropdown-item" href="Logout">
                        <i class="fas fa-sign-out-alt"></i> Logout</a>
                </div>
            </li>
        </ul>

    </div>
</nav>

<div class="modal fade" id="deleteAccountModal" tabindex="-1" role="dialog" aria-labelledby="deleteAccountModalTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteAccountModalTitle">Confirm Account Deletion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you wish to delete your account? This is a permanent action and all you progress will be lost forever.
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-secondary" data-dismiss="modal" href="DeleteAccount">Close</button>
                <form action="DeleteAccount" method="POST">
                    <button type="submit" class="btn btn-danger">Delete Account</button>
                </form>
            </div>
        </div>
    </div>
</div>
