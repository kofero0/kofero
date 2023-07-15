#!
echo $1
git clone git@github.com:mitchelldrew/kofero-presenter-pod.git
cd kofero-presenter-pod
git checkout -b $1
mv ../build/fat-framework/debug/presenter.framework presenter.framework
git add --a
git commit --m "empty"
git push -u origin $1
cd ..
rm -rf kofero-presenter-pod