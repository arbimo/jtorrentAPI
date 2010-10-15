/*
 * Java Bittorrent API as its name indicates is a JAVA API that implements the Bittorrent Protocol
 * This project contains two packages:
 * 1. jBittorrentAPI is the "client" part, i.e. it implements all classes needed to publish
 *    files, share them and download them.
 *    This package also contains example classes on how a developer could create new applications.
 * 2. trackerBT is the "tracker" part, i.e. it implements a all classes needed to run
 *    a Bittorrent tracker that coordinates peers exchanges. *
 *
 * Copyright (C) 2007 Baptiste Dubuis, Artificial Intelligence Laboratory, EPFL
 *
 * This file is part of jbittorrentapi-v1.0.zip
 *
 * Java Bittorrent API is free software and a free user study set-up;
 * you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Java Bittorrent API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Java Bittorrent API; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * @version 1.0
 * @author Arthur Bit-Monnot
 * To contact the author:
 * email: athanare@gmail.com
 *
 * More information about Java Bittorrent API:
 *    http://sourceforge.net/projects/bitext/
 */

package com.jtorrentapi;


/**
 * Stores general informations about the torrent.
 * @author Arthur Bit-Monnot
 *
 */
public class TorrentInfo {

	private long downloaded = 0;
    private long uploaded = 0;
    private long length = 0;
    private String event = "&event=started";
    private int listeningPort = 6881;
    
    /**
     * Constructs a TorrentInfo
     * @param downloaded The amount of data downloaded until now 
     * @param uploaded The amount of data uploaded until now 
     * @param length The total length of the torrent files
     */
    public TorrentInfo(long downloaded, long uploaded, long length) {
    	this.downloaded = downloaded;
    	this.uploaded = uploaded;
    	this.length = length;
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
