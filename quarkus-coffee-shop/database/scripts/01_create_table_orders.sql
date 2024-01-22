
CREATE TABLE orders (
    uuid VARCHAR(36) PRIMARY KEY,
    type VARCHAR(32) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

COMMENT ON COLUMN orders.type IS E'the type of coffee';
