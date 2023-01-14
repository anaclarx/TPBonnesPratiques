package com.company;

import java.util.ArrayList;

public class WebServer  implements WebRequestObservable{

    private ArrayList<WebRequestObserver> requestObservers = new ArrayList<>();

    public RequestHandler firstRequest;

    public WebServer(RequestHandler firstRequest){
        this.firstRequest = firstRequest;
    }
    public String getRequest(WebRequest request) {
        this.firstRequest.handleRequest(request);
        notifyObservers(request);
        return request.getPath();
    }

    @Override
    public void attach(WebRequestObserver observer) {
        this.requestObservers.add(observer);
    }

    @Override
    public void detach(WebRequestObserver observer) {
        this.requestObservers.remove(observer);
    }

    @Override
    public void notifyObservers(WebRequest webRequest) {
        for(WebRequestObserver observer: this.requestObservers){
            observer.update(webRequest);
        }
    }
}
