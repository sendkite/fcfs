package com.example.consumer.consumer;

import com.example.consumer.domain.Coupon;
import com.example.consumer.domain.FailedEvent;
import com.example.consumer.repository.CouponRepository;
import com.example.consumer.repository.FailedEventRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;

    private final FailedEventRepository failedEventRepository;

    private final Logger logger = Logger.getLogger(CouponCreatedConsumer.class.getName());

    public CouponCreatedConsumer(CouponRepository couponRepository, FailedEventRepository failedEventRepository) {
        this.couponRepository = couponRepository;
        this.failedEventRepository = failedEventRepository;
    }

    @KafkaListener(topics = "coupon_create", groupId = "group_1")
    public void listener(Long userId) {
        try {
            couponRepository.save(new Coupon(userId));
        } catch (Exception e) {
            logger.info("failed to crate coupon: " + userId);
            failedEventRepository.save(new FailedEvent(userId));
        }
    }
}
