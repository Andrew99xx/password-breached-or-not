package com.indra.passwordchecker;

public class SearchPassAnon
{
    private String anon;

    private String str;

    private String count;

    private int wordlist;

    public void setAnon(String anon){
        this.anon = anon;
    }
    public String getAnon(){
        return this.anon;
    }
    public void setChar(String str){
        this.str = str;
    }
    public String getChar(){
        return this.str;
    }
    public void setCount(String count){
        this.count = count;
    }
    public String getCount(){
        return this.count;
    }
    public void setWordlist(int wordlist){
        this.wordlist = wordlist;
    }
    public int getWordlist(){
        return this.wordlist;
    }
}
