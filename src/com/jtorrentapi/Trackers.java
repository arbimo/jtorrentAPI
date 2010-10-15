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
