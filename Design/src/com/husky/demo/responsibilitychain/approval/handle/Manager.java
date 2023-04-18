package com.husky.demo.responsibilitychain.approval.handle;

public class Manager implements ApprovalHandle {

    protected ApprovalHandle handle;

    @Override
    public void next(ApprovalHandle approveHandle) {
        this.handle = approveHandle;
    }

    @Override
    public boolean doHandle(Integer memory) {
        if (memory < 100000) {
            System.out.println("我是经理,可以处理10万以下的钱");
            return true;
        }
        return handle.doHandle(memory);
    }
}
