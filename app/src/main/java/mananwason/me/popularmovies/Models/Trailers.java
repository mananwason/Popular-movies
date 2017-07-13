package mananwason.me.popularmovies.Models;

import java.util.List;

/**
 * Created by mananwason on 7/13/17.
 */

public class Trailers {
    private List<SingleTrailer> results;
    public List<SingleTrailer> getTrailers(){
        return results;
    }
    public void setTrailers(List<SingleTrailer> trailers) {
        this.results = trailers;
    }
    public static class SingleTrailer{
        String key;
        String name;
        public String getTitle(){return name;}
        public String getKey(){
            return key;
        }
        public void setKey(String key){
            this.key = key;
        }
    }

}
