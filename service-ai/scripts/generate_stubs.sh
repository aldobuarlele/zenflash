#!/bin/bash

mkdir -p stubs

python -m grpc_tools.protoc \
    -I../proto \
    --python_out=./stubs \
    --grpc_python_out=./stubs \
    ../proto/zenflash.proto

if [[ "$OSTYPE" == "darwin"* ]]; then
    # Versi macOS (M4)
    sed -i '' 's/import zenflash_pb2 as zenflash__pb2/from . import zenflash_pb2 as zenflash__pb2/g' stubs/zenflash_pb2_grpc.py
else
    # Versi Linux
    sed -i 's/import zenflash_pb2 as zenflash__pb2/from . import zenflash_pb2 as zenflash__pb2/g' stubs/zenflash_pb2_grpc.py
fi

echo "✅ Stubs generated successfully in service-ai/stubs/"