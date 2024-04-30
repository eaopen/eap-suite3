package org.openea.eap.module.trade.dal.mysql.config;

import org.openea.eap.framework.mybatis.core.mapper.BaseMapperX;
import org.openea.eap.module.trade.dal.dataobject.config.TradeConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 交易中心配置 Mapper
 *
 * @author owen
 */
@Mapper
public interface TradeConfigMapper extends BaseMapperX<TradeConfigDO> {

}
