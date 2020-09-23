package com.ebayirnbank.ebayironbankstarter;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class OnProdCondition implements Condition {

    private static Boolean answer;

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (answer == null) {

            answer = JOptionPane.showInputDialog("is it production?").toLowerCase().contains("yes");
        }

        return answer;
    }
}
