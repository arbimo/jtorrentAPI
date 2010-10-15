package com.jtorrentapi;

public class TorrentInfo {

	
	
	private long downloaded = 0;
    private long uploaded = 0;
    //private long left = 0;
    private long length = 0;
    private String event = "&event=started";
    private int listeningPort = 6881;
    
    public TorrentInfo() {
		
	}
    
    public TorrentInfo(long downloaded, long uploaded, long length) {
    	this.downloaded = downloaded;
    	this.uploaded = uploaded;
    	this.length = length;
    }
    
    public String getStats() {
    	return new String("Dl : "+downloaded+ "- Ul : "+uploaded
    			+" - Left :" +(length-downloaded)+" - Length : "+length);
    }

    /**
     * Returns the number of bytes that have been downloaded so far
     * @return int
     */
    public long getDownloaded() {
        return this.downloaded;
    }

    /**
     * Returns the number of bytes that have been uploaded so far
     * @return int
     */
    public long getUploaded() {
        return this.uploaded;
    }

    /**
     * Returns the number of bytes still to download to complete task
     * @return int
     */
    public long getLeft() {
        return this.length - this.downloaded;
    }

    /**
     * Returns the length of the torrent in bytes
     * @return int
     */
    public long getLength() {
        return this.length;
    }
    
    /**
     * Returns the current event of the client
     * @return int
     */
    public String getEvent() {
        return this.event;
    }
    
    /**
     * Returns the current listening port
     * @return int
     */
    public long getListeningPort() {
        return this.listeningPort;
    }
    
    /**
     * Sets the # of bytes downloaded so far
     * @param dl long
     */
    public void setDownloaded(long dl) {
        this.downloaded = dl;
    }

    /**
     * Sets the # of bytes uploaded so far
     * @param ul long
     */
    public void setUploaded(long ul) {
        this.uploaded = ul;
    }

    /**
     * Sets the # of bytes still to download
     * @param left long
     */
    public void setLeft(long left) {
        this.downloaded = this.length - left;
    }
    
    /**
     * Sets the length of the torrent
     * @param left long
     */
    public void setLength(long length) {
        this.length= length;
    }

    /**
     * Sets the current state of the client
     * @param event String
     */
    public void setEvent(String event) {
        this.event = event;
    }
    
    public void setListeningPort(int port){
        this.listeningPort = port;
    }
    
    /**
     * Add to the # of bytes downloaded so far
     * @param dl long
     */
    public void addDownloaded(long dl) {
        this.downloaded += dl;
    }

    /**
     * Add to the # of bytes uploaded so far
     * @param ul long
     */
    public void addUploaded(long ul) {
        this.uploaded += ul;
    }

    /**
     * Subtract to the # of bytes still to download
     * @param left long
     */
    public void subLeft(long left) {
        this.downloaded += left;
    }

    /**
     * Update the parameters for future tracker communication
     * @param dl int
     * @param ul int
     * @param event String
     */
    public synchronized void updateParameters(int dl, int ul, String event) {
        synchronized (this) {
        	this.downloaded += dl;
        	this.uploaded += ul;
        	this.event = event;
        }
    }


}
