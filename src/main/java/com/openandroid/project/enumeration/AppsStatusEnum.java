package com.openandroid.project.enumeration;

public enum AppsStatusEnum {
    ACTIVE {
        @Override
        public String toString() {
            return "ACTIVE";
        }
    },ABANDONED {
        @Override
        public String toString() {
            return "ABANDONED";
        }
    },SLOWUPDATE {
        @Override
        public String toString() {
            return "SLOWUPDATE";
        }
    },UNKNOWN {
        @Override
        public String toString() {
            return "UNKNOWN";
        }
    }
}
