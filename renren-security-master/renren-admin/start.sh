dir_base='/root/dapin'
jar_name='renren-admin.jar'
echo 'kill  '+${jar_name}+'  start...'
if [$(pgrep -f ${jar_name} | wc -l) -gt 0]; then
  pkill -9 -f ${jar_name}
fi

echo 'start  '+${jar_name}+'...'

nohup java -jar ${dir_base}/${jar_name} --spring.config.location=${dir_base}/application.yml &
sleep 3
echo 'start success...'
  
  
