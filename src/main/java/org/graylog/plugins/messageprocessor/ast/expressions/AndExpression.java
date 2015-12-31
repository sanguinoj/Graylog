package org.graylog.plugins.messageprocessor.ast.expressions;

import org.graylog.plugins.messageprocessor.EvaluationContext;
import org.graylog2.plugin.Message;

public class AndExpression extends BinaryExpression implements LogicalExpression {
    public AndExpression(LogicalExpression left,
                         LogicalExpression right) {
        super(left, right);
    }

    @Override
    public Object evaluate(EvaluationContext context, Message message) {
        return evaluateBool(context, message);
    }

    @Override
    public boolean evaluateBool(EvaluationContext context, Message message) {
        return ((LogicalExpression)left).evaluateBool(context, message) && ((LogicalExpression)right).evaluateBool(context, message);
    }

    @Override
    public Class getType() {
        return Boolean.class;
    }

    @Override
    public String toString() {
        return left.toString() + " AND " + right.toString();
    }
}
