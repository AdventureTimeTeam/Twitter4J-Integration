package com.fiap.controller;

import com.fiap.utils.MyUtils;

import twitter4j.Query;

public class TweetQuery {

	public Query getQueryLastWeek() {
		Query query = new Query("#javaone");
		String since = MyUtils.getLastWeekDateStart();
		String until = MyUtils.getLastWeekDateEnd();
		query.setSince(since);
		query.since(since);
		query.until(until);
		return query;
	}
	
	public Query getQuery() {
		Query query = new Query("#megsauro");
		return query;
	}
	
}
