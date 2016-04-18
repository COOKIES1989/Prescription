/**
 * 
 */
package org.lee.prescription.serviceImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.lee.prescription.model.CFXXB;
import org.lee.prescription.model.CFYPXXB;
import org.lee.prescription.service.CfglService;
import org.lee.prescription.util.JsonUtil;
import org.lee.prescription.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CfglServiceImpl
 * @Description 处方管理实现类
 * @Date 2015年8月26日 下午9:24:27
 * @author LIJW
 *
 */
@Service
@Transactional
public class CfglServiceImpl implements CfglService{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	/**
	 * @Description 模糊查询药品信息
	 * @param tbn
	 * @param value
	 * @autor LIJW
	 * @date 2015年9月6日 下午8:32:01
	 */
	@Cacheable(value={"CODE_CACHE"})
	
	public String getYpxx(String tbn, String value) throws Exception {
		String sql ="select ypqc , ypdm from "+tbn.toUpperCase()+" where yppyjc like '"+value+"%' order by ypdm";
		return this.getMyQuery(sql);
	}
	
	
	
	/**
	 * 
	 * @Description 保存处方信息，包括患者基本信息和处方药品信息
	 * @param cfxxb
	 * @param cfypxxb
	 * @return
	 * @throws Exception
	 * @autor LIJW
	 * @date 2015年9月9日 下午8:33:58
	 */
	public String saveCfxx(CFXXB cfxxb, CFYPXXB cfypxxb) throws Exception {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String[] ypdms = cfypxxb.getYpdm().split(",");
		String[] ypqcs = cfypxxb.getYpqc().split(",");
		
		String[] ypjls = cfypxxb.getYpjl().split(",");
		String[] ypjlzws = cfypxxb.getYpjlzw().split(",");
		
		String[] fyfss = cfypxxb.getFyfs().split(",");
		String[] fyfszws = cfypxxb.getFyfszw().split(",");
		
		String[] sfzjs = cfypxxb.getSfzj().split(",");
		String[] sfzjzws = cfypxxb.getSfzjzw().split(",");
		
		String cfzj = this.saveCfjbxx(cfxxb);
		
		for (int i = 0; i < ypqcs.length; i++) {
			if(StringUtil.validStr(ypqcs[i])){
//				System.out.println(ypdms[i]+","+ypqcs[i]+","+ypjls[i]+","+ypjlzws[i]+","+fyfss[i]+","+fyfszw[i]+","+sfzjs[i]+","+sfzjzws[i]);
				CFYPXXB ypxx = new CFYPXXB(cfzj, ypqcs[i], ypjls[i], ypjlzws[i], fyfss[i], fyfszws[i], sfzjs[i], sfzjzws[i], ypdms[i]);
				session.save(ypxx);
			}
		}
		return cfzj;
	}


	/**
	 * 
	 * @Description 保存处方基本信息
	 * @param cfxxb
	 * @return 处方信息主键
	 * @throws Exception
	 * @autor LIJW
	 * @date 2015年9月9日 下午9:21:08
	 */
	
	public String saveCfjbxx(CFXXB cfxxb) throws Exception {
		cfxxb.setCfsj(StringUtil.getSysDateStr(new Date()));
		Session session = this.sessionFactory.getCurrentSession();
		Serializable s = session.save(cfxxb);
		return s.toString();
	}
	

	/**
	 * @Description 追加处方药品信息
	 * @param cfypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午6:59:54
	 */
	
	public String saveMoreCfyp(CFYPXXB cfypxxb) throws Exception {
		Serializable s = this.sessionFactory.getCurrentSession().save(cfypxxb);
		return s.toString();
	}



	/**
	 * 
	 * @Description 根据处方主键查询处方所含药品信息
	 * @param cfzj
	 * @return 处方上所有的药品信息
	 * @throws Exception
	 * @autor JIANGMJ
	 * @date 2015年9月10日 下午5:32:34
	 */
	
	public List<CFYPXXB> getCfypxx(String cfzj) throws Exception {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CFYPXXB.class);
		criteria.add(Restrictions.eq("cfzj", cfzj));
		criteria.addOrder(Order.asc("sfzj"));
		List<CFYPXXB> cfypxxs = criteria.list();
		return cfypxxs;
	}


	/**
	 * @Description 删除处方药品信息
	 * @param cfypxxb
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午4:28:21
	 */
	
	public void deleteCfypxx(CFYPXXB cfypxxb) throws Exception {
		this.sessionFactory.getCurrentSession().delete(cfypxxb);
	}

	

	/**
	 * @Description 查询一条处方药品信息
	 * @param cfypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午4:30:35
	 */
	
	public CFYPXXB getOneCfypxx(CFYPXXB cfypxxb) throws Exception {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CFYPXXB.class);
		criteria.add(Restrictions.eq("uuid", cfypxxb.getUuid()));
		List<CFYPXXB> list = criteria.list(); 
		return list.size() == 0 ? null : list.get(0);
	}


	/**
	 * @Description 更新处方药品信息
	 * @param cfypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年9月18日 下午4:58:54
	 */
	
	public void updateCfypxx(CFYPXXB cfypxxb) throws Exception {
		this.sessionFactory.getCurrentSession().update(cfypxxb);
	}



	/**
	 * 封装SQLQuery的获取、查询操作及查询结果转换
	 * @param sb 
	 * @return json格式数据
	 * @throws HibernateException
	 * @throws Exception
	 */
	private String getMyQuery(String sql) throws HibernateException,
			Exception {
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		List list = query.list();
		return JsonUtil.toJson(list);
	}
	
	
	

}
