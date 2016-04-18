package org.lee.prescription.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.lee.prescription.model.YPXXB;
import org.lee.prescription.service.YpglService;
import org.lee.prescription.util.PageUtil;
import org.lee.prescription.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName YpglServiceImpl
 * @Description 药品信息管理
 * @Date 2015年8月5日 下午2:39:40
 * @author lijw
 *
 */
@Service
@Transactional
public class YpglServiceImpl implements YpglService {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @Description 添加药品信息
	 * @param ypxxb
	 * @return
	 * @autor lijw
	 * @date 2015年8月5日 下午2:37:09
	 */
	
	public String saveYpxx(YPXXB ypxxb) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		ypxxb.setYpqc(ypxxb.getYpmc()+"("+ypxxb.getYpjlzw()+"、"+ypxxb.getYpjxzw()+"、"+ypxxb.getYpcjzw()+")");
		ypxxb.setYpdm(this.getSequence5());
		Serializable s = session.save(ypxxb);
		return s.toString();
	}

	/**
	 * @Description 查询药品信息
	 * @param ypxxb
	 * @return
	 * @autor lijw
	 * @date 2015年8月5日 下午2:37:32
	 */
	
	public List<YPXXB> getYpxx(YPXXB ypxxb) throws Exception {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(YPXXB.class);
		criteria.add(Restrictions.like("yppyjc", ypxxb.getYppyjc()));
		return criteria.list();
	}
	
	/**
	 * @Description 查询全部的药品信息
	 * @return
	 * @autor lijw
	 * @date 2015年8月5日 下午2:38:19
	 */
	
	public ResultModel getAllYpxx(PageUtil pageUtil) throws Exception {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(YPXXB.class);
		int total = criteria.list().size();
		this.pageAndOrder(pageUtil, criteria, Order.desc("ypdm"));
		return new ResultModel("OK", "OK", total , criteria.list());
	}
	
	/**
	 * @Description 根据主键查询一条药品信息
	 * @param ypxxb
	 * @return
	 * @throws Exception
	 * @autor lijw
	 * @date 2015年8月6日 下午5:15:53
	 */
	
	public YPXXB getOneYpxx(YPXXB ypxxb) throws Exception {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(YPXXB.class);
		criteria.add(Restrictions.eq("uuid", ypxxb.getUuid()));
		List<YPXXB> list = criteria.list();
		return list.size() == 0 ? null : list.get(0);
	}

	/**
	 * @Description 删除药品信息
	 * @param ypxxb
	 * @autor lijw
	 * @date 2015年8月5日 下午2:38:36
	 */
	
	public void deleteYpxx(YPXXB ypxxb) throws Exception {
		this.sessionFactory.getCurrentSession().delete(ypxxb);
	}
	
	/**
	 * @Description 更新药品信息
	 * @param ypxxb
	 * @autor lijw
	 * @date 2015年8月5日 下午2:38:56
	 */
	
	public void updateYpxx(YPXXB ypxxb) throws Exception {
		ypxxb.setYpqc(ypxxb.getYpmc()+"("+ypxxb.getYpjlzw()+"、"+ypxxb.getYpjxzw()+"、"+ypxxb.getYpcjzw()+")");
		this.sessionFactory.getCurrentSession().update(ypxxb);
	}
	
	/**
	 * @Description 从序列中取值的方法
	 * @return
	 * @autor lijw
	 * @date 2015年8月6日 下午3:15:51
	 */
	public String getSequence5 (){
		String sql = "SELECT YPXXB_SEQ.NEXTVAL FROM DUAL";
		SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		List list = query.list();
		return list.get(0).toString();
	}
	
	/**
	 * 用于分页和排序的方法
	 * @param pageUtil 分页对象
	 * @param criteria 查询对象 
	 * @param order 排序对象
	 * @throws Exception
	 */
	private void pageAndOrder(PageUtil pageUtil, Criteria criteria , Order order)
			throws Exception {
		int pageNo = Integer.parseInt((pageUtil.getPage() == null || pageUtil
				.getPage() == "0") ? "1" : pageUtil.getPage());// 第几页
		int pageSize = Integer.parseInt((pageUtil.getRows() == null || pageUtil
				.getRows() == "0") ? "10" : pageUtil.getRows());// 每页多少行
		// 排序
		criteria.addOrder(order);
		// 分页
		criteria.setFirstResult((pageNo - 1) * pageSize);
		criteria.setMaxResults(pageSize);
	}

}
