package org.openea.eap.module.statistics.dal.mysql.trade;

import org.openea.eap.framework.mybatis.core.mapper.BaseMapperX;
import org.openea.eap.module.statistics.dal.dataobject.trade.TradeStatisticsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * 订单分销的统计 Mapper
 *
 * @author owen
 */
@Mapper
public interface BrokerageStatisticsMapper extends BaseMapperX<TradeStatisticsDO> {

    Integer selectSummaryPriceByStatusAndUnfreezeTimeBetween(@Param("bizType") Integer bizType,
                                                             @Param("status") Integer status,
                                                             @Param("beginTime") LocalDateTime beginTime,
                                                             @Param("endTime") LocalDateTime endTime);

    Long selectWithdrawCountByStatus(@Param("status") Integer status);

}
