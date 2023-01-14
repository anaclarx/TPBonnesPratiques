package com.company;

public class ExistingContentRequestHandler extends RequestHandler {
    @Override
    public void handleRequest(WebRequest request) {
        String path = request.getPath();
        if(path.equals("/dashboard") || path.equals("/home")){
            System.out.println("Valid request path");
            this.successorRequest(request);
        }
        else{
            System.out.println("Status 404 : Page missing");
        }
    }
}
//    String path = request.getPath();
//    User user = request.getLoggedUser();
//        if((user.isAdmin()) && (path.equals("/dashboard") || path.equals("/home"))){
//                System.out.println("Valid Path and User");
//                return;
//                } else if (!(user.isAdmin()) && path.equals("/home")) {
//                System.out.println("Valid Path and User");
//                return;
//                } else if (!(user.isAdmin()) && path.equals("/dashboard")) {
//                System.out.println("Status 403 : user is not authorized to access this content");
//                return;
//                } else{
//                System.out.println("Status 404 : Page missing");
//                }