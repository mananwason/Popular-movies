package mananwason.me.popularmovies.Models;

import java.util.ArrayList;

/**
 * Created by Manan Wason on 12/09/16.
 */
public class parseExtras {
    int page;
    ArrayList<Movie> results;
    int total_results;
    int total_pages;

    public parseExtras(int page, ArrayList<Movie> results, int total_results, int total_pages) {
        this.page = page;
        this.results = results;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
