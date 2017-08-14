package com.hfzs.framework.core.web.tags;

/**
 * RadiosTag
 * 
 * @author liufang
 * 
 */
public class RadiosTag extends AbstractMultiCheckedElementTag {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getInputType() {
		return "radio";
	}
}
