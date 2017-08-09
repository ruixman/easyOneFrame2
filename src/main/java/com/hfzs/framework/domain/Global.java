package com.hfzs.framework.domain;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.MapKeyType;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.*;

/**
 * 全局对象
 * 
 * @author liufang
 * 
 */
@Entity
@Table(name = "cms_global")
public class Global implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 模型类型
	 */
	public static final String MODEL_TYPE = "global";
	/**
	 * 系统预定义字段前缀
	 */
	public static final String SYS_PREFIX = "sys_";

	@Transient
	public static void removeAttr(Map<String, String> map, String prefix) {
		Set<String> keysToRemove = new HashSet<String>();
		for (String key : map.keySet()) {
			if (key.startsWith(prefix)) {
				keysToRemove.add(key);
			}
		}
		for (String key : keysToRemove) {
			map.remove(key);
		}
	}

	@Transient
	public static void removeAttrExcludeSys(Map<String, String> map) {
		Set<String> keysToRemove = new HashSet<String>();
		for (String key : map.keySet()) {
			if (!key.startsWith(SYS_PREFIX)) {
				keysToRemove.add(key);
			}
		}
		for (String key : keysToRemove) {
			map.remove(key);
		}
	}

	/**
	 * 根据配置对象的类名获取配置对象
	 * 
	 * @param className
	 *            类完整名
	 * @return 类名对应的配置对象
	 */
	@Transient
	public Object getConf(String className) {
		try {
			return Class.forName(className).getConstructor(Map.class).newInstance(getCustoms());
		} catch (Exception e) {
			throw new IllegalArgumentException("Class '" + className + "' is not Conf Class", e);
		}
	}

	private Integer id;
	private Map<String, String> customs = new HashMap<String, String>(0);
	private Map<String, String> clobs = new HashMap<String, String>(0);

	private String protocol;
	private Integer port;
	private String contextPath;
	private Integer captchaErrors;

	private String dataVersion;

	@Id
	@Column(name = "f_global_id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ElementCollection
	@CollectionTable(name = "cms_global_custom", joinColumns = @JoinColumn(name = "f_global_id"))
	@MapKeyColumn(name = "f_key", length = 50)
	@Column(name = "f_value", length = 2000)
	public Map<String, String> getCustoms() {
		return this.customs;
	}

	public void setCustoms(Map<String, String> customs) {
		this.customs = customs;
	}

	@ElementCollection
	@CollectionTable(name = "cms_global_clob", joinColumns = @JoinColumn(name = "f_global_id"))
	@MapKeyColumn(name = "f_key", length = 50)
	@MapKeyType(value = @Type(type = "string"))
	@Lob
	@Column(name = "f_value", nullable = false)
	public Map<String, String> getClobs() {
		return this.clobs;
	}

	public void setClobs(Map<String, String> clobs) {
		this.clobs = clobs;
	}

	@Length(max = 50)
	@Column(name = "f_protocol", length = 50)
	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Column(name = "f_port")
	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Length(max = 255)
	@Column(name = "f_context_path", length = 255)
	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	@Column(name = "f_captcha_errors", nullable = false)
	public Integer getCaptchaErrors() {
		return captchaErrors;
	}

	public void setCaptchaErrors(Integer captchaErrors) {
		this.captchaErrors = captchaErrors;
	}

	@Length(max = 50)
	@Column(name = "f_version", nullable = false, length = 50)
	public String getDataVersion() {
		return this.dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
}