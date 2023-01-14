package com.company;

public class PolicyCheckRequestHandler extends RequestHandler{
    @Override
    public void handleRequest(WebRequest request) {
        String path = request.getPath();
        User user = request.getLoggedUser();
        if((user.isAdmin()) && (path.equals("/dashboard") || path.equals("/home"))){
                System.out.println("Valid Path and User");
                this.successorRequest(request);
        } else if (!(user.isAdmin()) && path.equals("/home")) {
                System.out.println("Valid Path and User");
                this.successorRequest(request);
        } else if (!(user.isAdmin()) && path.equals("/dashboard")) {
                System.out.println("Status 403 : user is not authorized to access this content");
        }
    }
}
