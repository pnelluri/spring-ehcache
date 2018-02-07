package com.nisum.dao;

import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;
@Configuration
public class MyCacheListener implements CacheEventListener {
	public static final CacheEventListener INSTANCE = new MyCacheListener();
	@Override
	public void notifyElementPut(Ehcache cache, Element element)
			throws CacheException {

		//System.out.println("Event Notification: :: Element Put ::" + element);
	}

	@Override
	public void notifyElementEvicted(Ehcache cache, Element element) {

		System.out.println("Event Notification: :: Element Evicted ::" + element.getObjectKey());
	}

	@Override
	public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException {
		System.out.println("Event Notification: :: Element notifyElementRemoved ::" + element.getObjectKey());

	}

	@Override
	public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyElementExpired(Ehcache cache, Element element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyRemoveAll(Ehcache cache) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	public Object clone() {
		return null;

	}

}