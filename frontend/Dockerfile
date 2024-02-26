FROM node:21-alpine
RUN addgroup app && adduser -S -G app app
WORKDIR /app
COPY --chown=app:app package.json .
RUN npm install
COPY . .
USER app
EXPOSE 3000
CMD ["npm", "run", "start"]
