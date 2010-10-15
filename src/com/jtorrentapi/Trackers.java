package com.jtorrentapi;

import java.util.ArrayList;


/**
 * Class that stocks the different trackers url.
 * It is used to support the MultiTracker MetaData Extension.
 * @author Arthur Bit-Monnot
 *
 */
public class Trackers extends ArrayList<ArrayList<String>> {
	
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Trackers() {
		super();
	}
	
	/**
	 * Create a new Trackers object and add an url to it
	 * @param url
	 */
	public Trackers(String url) {
		super();
		ArrayList<String> list = new ArrayList<String>();
		list.add(url);
		this.add(list);
	}
	
	/**
	 * Add a single tracker.
	 * @param url Url of the tracker to add
	 */
	public void add(String url) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(url);
		this.add(list);
	}
	
	/**
	 * Return the default tracker.
	 * @return tracker url. null if there no tracker no registered
	 */
	public String getUrl() {
		if (this.size() > 0 && this.get(0).size() >0)
			return this.get(0).get(0);
		else 
			return null;
	}

}
