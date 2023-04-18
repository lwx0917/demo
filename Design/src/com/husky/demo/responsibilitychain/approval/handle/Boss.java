package com.husky.demo.responsibilitychain.approval.handle;

public class Boss implements ApprovalHandle {
    protected ApprovalHandle handle;

    @Override
    public void next(ApprovalHandle approveHandle) {
        this.handle = approveHandle;
    }


    @Override
    public boolean doHandle(Integer memory) {
        System.out.println("我是老板,我想怎么样就怎么样,还想出去玩,等下给你优化了");
        return true;
    }
}
